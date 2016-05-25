package com.sussol.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.sun.org.apache.regexp.internal.recompile;
import com.sussol.domain.controller.WekaClassifier;
import com.sussol.domain.controller.WekaModeller;
import com.sussol.domain.model.ArffGenerator;
import com.sussol.domain.model.InputProcessor;
import com.sussol.domain.model.data.JsonModel.ClassifiedInstance;
import com.sussol.domain.model.data.JsonModel.Model;
import com.sussol.domain.options.CanopyOptions;
import com.sussol.domain.options.CobWebOptions;
import com.sussol.domain.options.EMOptions;
import com.sussol.domain.options.KMeansOptions;
import com.sussol.domain.options.OptionsManager;
import com.sussol.domain.options.SOMOptions;
import com.sussol.domain.options.XMeansOptions;
import com.sussol.domain.utilities.ClassifierManager;
import com.sussol.domain.utilities.Globals;
import com.sussol.domain.utilities.Globals.Algorithm;

@RequestMapping("/api")
@RestController
public class ServiceController {
	
	@Autowired private ServletContext servletContext;
	private static final String STORAGE_PATH = System.getenv("OPENSHIFT_DATA_DIR") == null ? "/uploads/" : System.getenv("OPENSHIFT_DATA_DIR");
	private File fileConverter(MultipartFile multipartFile)
	{
		System.out.println(multipartFile.getOriginalFilename());
		File convFile = new File(STORAGE_PATH + multipartFile.getOriginalFilename());
	    try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile); 
		    fos.write(multipartFile.getBytes());
		    fos.close();
		    return convFile;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
	    return null;
	}
	
	private void initializeAPI(MultipartFile multipartFile) {
		File file;
		if(multipartFile == null || multipartFile.isEmpty())
		{
			file = new File("C:/matrix.csv");
		}else {
			file = fileConverter(multipartFile);
		}
			Globals.trainingFileName = file.getName();
	    	Globals.pathToArffFile += file.getName();
	    	ArffGenerator arffGenerator = new ArffGenerator(file.getAbsolutePath(), file.getName());
	    	arffGenerator.generateSustainableSolventsArff();
	    	arffGenerator.generateSubFiles();
	}
	
	@RequestMapping(value = "/model/canopy" , method= RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Model canopyModeller(@RequestParam(value = "file", required=true) MultipartFile file,@RequestParam(value = "t1", defaultValue = "-1.25", required=false) String t1, @RequestParam(value = "t2", defaultValue = "-1.0", required=false) String t2)
	{
		initializeAPI(file);
		OptionsManager canopyOptions = new CanopyOptions();
		canopyOptions.setOption("-t1", t1);
		canopyOptions.setOption("t2", t2);
		//options moeten nog niet worden meegegeven 
		WekaModeller modeller = new WekaModeller();
		return modeller.makeModel(Algorithm.CANOPY, canopyOptions, file.getOriginalFilename());
	}
	@RequestMapping(value = "/model/cobweb" , method= RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Model cobwebModeller(@RequestParam(value = "file", required=true) MultipartFile file,@RequestParam(value = "A", defaultValue = "1.0", required=false) String A, @RequestParam(value = "C", defaultValue = "0.05", required=false) String C, @RequestParam(value = "S", defaultValue = "100", required=false) String S)
	{
		initializeAPI(file);
		OptionsManager cobwebOptions = new CobWebOptions();
		cobwebOptions.setOption("-A", A);
		cobwebOptions.setOption("-C", C);
		cobwebOptions.setOption("-S", S);
		
		WekaModeller modeller = new WekaModeller();
		return modeller.makeModel(Algorithm.COBWEB, cobwebOptions, file.getOriginalFilename());
	}
	
	@RequestMapping(value = "/model/em" , method= RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Model emModeller(@RequestParam(value = "file", required=true) MultipartFile file,@RequestParam(value = "clusters", defaultValue = "-1.0", required=false) String clusters)
	{
		initializeAPI(file);
		OptionsManager emOptions = new EMOptions();
		//emOptions.setOption("-N", clusters);
		
		WekaModeller modeller = new WekaModeller();
		return modeller.makeModel(Algorithm.EM, emOptions, file.getOriginalFilename());
	}
	
	@RequestMapping(value = "/model/kmeans" , method= RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Model kmeansModeller(@RequestParam(value = "file", required=true) MultipartFile file,@RequestParam(value = "clusters", defaultValue = "4", required=false) String clusters)
	{
		initializeAPI(file);
		OptionsManager options = new KMeansOptions();
		options.setOption("-N", clusters);
		
		WekaModeller modeller = new WekaModeller();
		return modeller.makeModel(Algorithm.KMEANS, options, file.getOriginalFilename());
	}
	@RequestMapping(value = "/model/som" , method= RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Model somModeller(@RequestParam(value = "file", required=true) MultipartFile file,@RequestParam(value = "learningrate", defaultValue = "1.0", required=false) String learningrate)
	{
		initializeAPI(file);
		OptionsManager options = new SOMOptions();
		options.setOption("-N", learningrate);
		
		WekaModeller modeller = new WekaModeller();
		return modeller.makeModel(Algorithm.SOM, options, file.getOriginalFilename());
	}
	
	@RequestMapping(value = "/model/xmeans" , method= RequestMethod.POST, consumes="multipart/form-data")
	public @ResponseBody Model xmeansModeller(@RequestParam(value = "file", required=true) MultipartFile file,@RequestParam(value = "I", defaultValue = "1", required=false) String I,@RequestParam(value = "L", defaultValue = "2", required=false) String L,@RequestParam(value = "H", defaultValue = "4", required=false) String H)
	{
		initializeAPI(file);
		OptionsManager options = new XMeansOptions();
		options.setOption("-I", I);
		options.setOption("-L", L);
		options.setOption("-H", H);
		WekaModeller modeller = new WekaModeller();
		return modeller.makeModel(Algorithm.XMEANS, options, file.getOriginalFilename());
	}
	
	@RequestMapping(value = "/classify" , method= RequestMethod.POST)
	public @ResponseBody ClassifiedInstance classifySolvent(@RequestParam(value = "path", required=true) String path, @RequestParam(value="featureValues", required=true) String featureValues){
		
		return ClassifierManager.classifySolvent(path, featureValues);
	}
	
}
