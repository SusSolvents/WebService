<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<spring:url value="/resources/css/materialize.css" var="materializeCss" />
	<spring:url value="/resources/css/materialize.min.css" var="materializeminCss" />
	<spring:url value="/resources/css/style.css" var="styleCss" />
	<spring:url value="/resources/js/materialize.js" var="materializeJs" />
	<spring:url value="/resources/js/materialize.min.js" var="materializeminJs" />
	<spring:url value="/resources/js/init.js" var="initJs" />
    	
  <!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
 	<script src="${materializeJs}"></script> 
	<script src="${materializeminJs}"></script> 
	<script src="${initJs}"></script> 
	<script>
	$(document).ready(function(){
	    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
	    $('.modal-trigger').leanModal({
	    	 dismissible: true, // Modal can be dismissed by clicking outside of the modal
	         opacity: .5,
	    });
	  });
	
	</script>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="${materializeCss}" rel="stylesheet" />
    <link href="${materializeminCss}" rel="stylesheet" />
    <link href="${styleCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sustainable Solvents Web Service</title>
</head>
<body>
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="#" class="brand-logo">Sussol</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="#">Navbar Link</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Navbar Link</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>

  <div id="index-banner" class="parallax-container" style="min-height: 380px">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <h1 class="header center teal-text text-lighten-2">Sustainable Solvents API</h1>
        <div class="row center">
          <h5 class="header col s12 light">Explore all our algorithms and their usages. It's for free!</h5>
        </div>
        <div class="row center">
        <a class="modal-trigger btn" id="btnMore" href="#modal1">Get your own API key now!</a>
          
        </div>
        <br><br>

      </div>
    </div>
    <div class="parallax"><img src="https://upload.wikimedia.org/wikipedia/commons/c/c3/Glass_ochem_dof.png" alt="Unsplashed background img 1"></div>
  </div>
<div id="modalcanopy" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>How to use the canopy algorithm?</h4>
      <hr/>
      <h5>The basic URL call:</h5>
      <p>You can send a HTTP-POST Request to following url:</p>
      <p style="font-size:120%" class="header teal-text text-lighten-2">http://www.susolapi.net/api/canopy + parameters</p>
      <h5>The parameters:</h5>
      <table class="highlight">
        <thead>
          <tr>
              <th>Parameter</th>
              <th>Key</th>
              <th>Possible Value</th>
              <th>Example</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>CSV file (required)</td>
            <td>file</td>
            <td>matrix.csv</td>
            <td class="teal-text text-lighten-2">.../canopy?file=C:/matrix.csv</td>
          </tr>
          <tr>
            <td>T1 Radius (optional)</td>
            <td>t1</td>
            <td>-1.25</td>
            <td class="teal-text text-lighten-2">.../canopy?file=C:/matrix.csv&t1=2.5</td>
            </tr>
          <tr>
            <td>T2 Radius (optional)</td>
            <td>t2</td>
            <td>-1.50</td>
            <td class="teal-text text-lighten-2">.../canopy?file=C:/matrix.csv&t2=3.0</td>
          </tr>
        </tbody>
      </table>
      <h5>The result:</h5>
      <p>When the processing of your csv file is done you get a response with a great JSON file. This JSON result contains various elements of the analysis. 
      	You can convert this JSON results into POJO objects or you can copy/paste the full log file of it. 
      </p>
      
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close btn-flat ">Got it!</a>
    </div>
  </div>
  
  <div id="modalcobweb" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>How to use the cobweb algorithm?</h4>
      <hr/>
      <h5>The basic URL call:</h5>
      <p>You can send a HTTP-POST Request to following url:</p>
      <p style="font-size:120%" class="header teal-text text-lighten-2">http://www.susolapi.net/api/cobweb + parameters</p>
      <h5>The parameters:</h5>
      <table class="highlight">
        <thead>
          <tr>
              <th>Parameter</th>
              <th>Key</th>
              <th>Possible Value</th>
              <th>Example</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>CSV file (required)</td>
            <td>file</td>
            <td>matrix.csv</td>
            <td class="teal-text text-lighten-2">.../cobweb?file=C:/matrix.csv</td>
          </tr>
          <tr>
            <td>Acuity (optional)</td>
            <td>A</td>
            <td>1.0</td>
            <td class="teal-text text-lighten-2">.../cobweb?file=C:/matrix.csv&A=1.0</td>
            </tr>
          <tr>
            <td>Cutoff (optional)</td>
            <td>C</td>
            <td>0.05</td>
            <td class="teal-text text-lighten-2">.../cobweb?file=C:/matrix.csv&C=0.05</td>
          </tr>
          <tr>
            <td>Seed (optional)</td>
            <td>S</td>
            <td>100</td>
            <td class="teal-text text-lighten-2">.../cobweb?file=C:/matrix.csv&S=100</td>
          </tr>
        </tbody>
      </table>
      <h5>The result:</h5>
      <p>When the processing of your csv file is done you get a response with a great JSON file. This JSON result contains various elements of the analysis. 
      	You can convert this JSON results into POJO objects or you can copy/paste the full log file of it. 
      </p>
      
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close btn-flat ">Got it!</a>
    </div>
  </div>
  <div id="modalem" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>How to use the EM algorithm?</h4>
      <hr/>
      <h5>The basic URL call:</h5>
      <p>You can send a HTTP-POST Request to following url:</p>
      <p style="font-size:120%" class="header teal-text text-lighten-2">http://www.susolapi.net/api/em + parameters</p>
      <h5>The parameters:</h5>
      <table class="highlight">
        <thead>
          <tr>
              <th>Parameter</th>
              <th>Key</th>
              <th>Possible Value</th>
              <th>Example</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>CSV file (required)</td>
            <td>file</td>
            <td>matrix.csv</td>
            <td class="teal-text text-lighten-2">.../em?file=C:/matrix.csv</td>
          </tr>
          <tr>
            <td>Number of clusters (optional)</td>
            <td>clusters</td>
            <td>-1</td>
            <td class="teal-text text-lighten-2">.../em?file=C:/matrix.csv&t1=2.5</td>
            </tr>
        </tbody>
      </table>
      <h5>The result:</h5>
      <p>When the processing of your csv file is done you get a response with a great JSON file. This JSON result contains various elements of the analysis. 
      	You can convert this JSON results into POJO objects or you can copy/paste the full log file of it. 
      </p>
      
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close btn-flat ">Got it!</a>
    </div>
  </div>
   <div id="modalkmeans" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>How to use the KMeans algorithm?</h4>
      <hr/>
      <h5>The basic URL call:</h5>
      <p>You can send a HTTP-POST Request to following url:</p>
      <p style="font-size:120%" class="header teal-text text-lighten-2">http://www.susolapi.net/api/kmeans + parameters</p>
      <h5>The parameters:</h5>
      <table class="highlight">
        <thead>
          <tr>
              <th>Parameter</th>
              <th>Key</th>
              <th>Possible Value</th>
              <th>Example</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>CSV file (required)</td>
            <td>file</td>
            <td>matrix.csv</td>
            <td class="teal-text text-lighten-2">.../kmeans?file=C:/matrix.csv</td>
          </tr>
          <tr>
            <td>Number of clusters (optional)</td>
            <td>clusters</td>
            <td>4</td>
            <td class="teal-text text-lighten-2">.../kmeans?file=C:/matrix.csv&clusters=4</td>
            </tr>
        </tbody>
      </table>
      <h5>The result:</h5>
      <p>When the processing of your csv file is done you get a response with a great JSON file. This JSON result contains various elements of the analysis. 
      	You can convert this JSON results into POJO objects or you can copy/paste the full log file of it. 
      </p>
      
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close btn-flat ">Got it!</a>
    </div>
  </div>
 <div id="modalsom" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>How to use the Self-Organizing Map algorithm?</h4>
      <hr/>
      <h5>The basic URL call:</h5>
      <p>You can send a HTTP-POST Request to following url:</p>
      <p style="font-size:120%" class="header teal-text text-lighten-2">http://www.susolapi.net/api/som + parameters</p>
      <h5>The parameters:</h5>
      <table class="highlight">
        <thead>
          <tr>
              <th>Parameter</th>
              <th>Key</th>
              <th>Possible Value</th>
              <th>Example</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>CSV file (required)</td>
            <td>file</td>
            <td>matrix.csv</td>
            <td class="teal-text text-lighten-2">.../som?file=C:/matrix.csv</td>
          </tr>
          <tr>
            <td>Learning Rate (optional)</td>
            <td>learningrate</td>
            <td>1</td>
            <td class="teal-text text-lighten-2">.../som?file=C:/matrix.csv&learningrate=1.0</td>
          </tr>
        </tbody>
      </table>
      <h5>The result:</h5>
      <p>When the processing of your csv file is done you get a response with a great JSON file. This JSON result contains various elements of the analysis. 
      	You can convert this JSON results into POJO objects or you can copy/paste the full log file of it. 
      </p>
      
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close btn-flat ">Got it!</a>
    </div>
  </div>
   <div id="modalxmeans" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>How to use the XMeans algorithm?</h4>
      <hr/>
      <h5>The basic URL call:</h5>
      <p>You can send a HTTP-POST Request to following url:</p>
      <p style="font-size:120%" class="header teal-text text-lighten-2">http://www.susolapi.net/api/xmeans + parameters</p>
      <h5>The parameters:</h5>
      <table class="highlight">
        <thead>
          <tr>
              <th>Parameter</th>
              <th>Key</th>
              <th>Possible Value</th>
              <th>Example</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>CSV file (required)</td>
            <td>file</td>
            <td>matrix.csv</td>
            <td class="teal-text text-lighten-2">.../xmeans?file=C:/matrix.csv</td>
          </tr>
          <tr>
            <td>Max. number of iterations (optional)</td>
            <td>I</td>
            <td>1</td>
            <td class="teal-text text-lighten-2">.../xmeans?file=C:/matrix.csv&I=1</td>
            </tr>
          <tr>
            <td>Min. number of clusters (optional)</td>
            <td>L</td>
            <td>2</td>
            <td class="teal-text text-lighten-2">.../xmeans?file=C:/matrix.csv&L=2</td>
          </tr>
          <tr>
            <td>Max. number of clusters (optional)</td>
            <td>H</td>
            <td>4</td>
            <td class="teal-text text-lighten-2">.../xmeans?file=C:/matrix.csv&H=4</td>
          </tr>
        </tbody>
      </table>
      <h5>The result:</h5>
      <p>When the processing of your csv file is done you get a response with a great JSON file. This JSON result contains various elements of the analysis. 
      	You can convert this JSON results into POJO objects or you can copy/paste the full log file of it. 
      </p>
      
    </div>
    <div class="modal-footer">
      <a href="#!" class="modal-action modal-close btn-flat ">Got it!</a>
    </div>
  </div>
  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">flash_on</i></h2>
            <h5 class="center">Canopy</h5>

            <p class="light">The canopy clustering algorithm is an unsupervised pre-clustering algorithm introduced by McCallum. It is often used as preprocessing step for the K-means algorithm or the Hierarchical clustering algorithm. It is intended to speed up clustering operations on large data sets, where using another algorithm directly may be impractical due to the size of the data set.</p>
          <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalcanopy">How to use canopy?</a>
          
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">group</i></h2>
            <h5 class="center">Cobweb</h5>

            <p class="light">Cobweb incrementally organizes observations into a classification tree. Each node in a classification tree represents a class (concept) and is labeled by a probabilistic concept that summarizes the attribute-value distributions of objects classified under the node. This classification tree can be used to predict missing attributes or the class of a new object.</p>
          <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalcobweb">How to use cobweb?</a>
          
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">settings</i></h2>
            <h5 class="center">EM</h5>

            <p class="light">In statistics, an expectation maximization (EM) algorithm is an iterative method for finding maximum likelihood or maximum a posterior (MAP) estimates of parameters in statistical models, where the model depends on unobserved latent variables. The EM iteration alternates between performing an expectation (E) step and a maximization (M) step.</p>
          <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalem">How to use EM?</a>
          
        </div>
          </div>
        </div>
      </div>

    </div>
  </div>


  <div class="parallax-container valign-wrapper" style="min-height: 20px">
    <div class="section no-pad-bot">
      <div class="container">
        <div class="row center">
          
        </div>
      </div>
    </div>
    <div class="parallax"><img src="https://upload.wikimedia.org/wikipedia/commons/c/c3/Glass_ochem_dof.png" alt="Unsplashed background img 2"></div>
  </div>

  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">flash_on</i></h2>
            <h5 class="center">KMeans</h5>

            <p class="light">k-means clustering is a method of vector quantization, originally from signal processing, that is popular for cluster analysis in data mining. k-means clustering aims to partition n observations into k clusters in which each observation belongs to the cluster with the nearest mean, serving as a prototype of the cluster. </p>
          <div class="row center">
        	<a class="modal-trigger btn-flat" href="#modalkmeans">How to use KMeans?</a>
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">group</i></h2>
            <h5 class="center">Self Organising Map</h5>

            <p class="light">A self-organizing map (SOM) is a type of artificial neural network (ANN) that is trained using unsupervised learning to produce a two-dimensional, discretized representation of the input space of the training samples, called a map. They apply competitive learning as opposed to error-correction learning.</p>
            <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalsom">How to use Self-Organizing Map?</a>
          
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">settings</i></h2>
            <h5 class="center">XMeans</h5>

            <p class="light">Extending K-means with Efficient Estimation of the Number of Clusters. X-Means is K-Means extended by an Improve-Structure part In this part of the algorithm the centers are attempted to be split in its region. The decision between the children of each center and itself is done comparing the BIC-values of the two structures.</p>
          <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalxmeans">How to use XMeans?</a>
          
        </div>
          </div>
        </div>
      </div>

    </div>
  </div>


  <div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
      <div class="container">
        <div class="row center">
          <h5 class="header col s12 light">Today we are working very hard to introduce more algorithms. Enjoy our work!</h5>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="https://upload.wikimedia.org/wikipedia/commons/c/c3/Glass_ochem_dof.png" alt="Unsplashed background img 3"></div>
  </div>

  <footer class="page-footer teal">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Who are we?</h5>
          <p class="grey-text text-lighten-4">We are two college students from Antwerp. We made this project for our internship at the company Qframe situated at Kontich, Belgium.</p>
        </div>
        
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by JJ & LB with lots of love and dedication
      </div>
    </div>
  </footer>


  </body>
</html>