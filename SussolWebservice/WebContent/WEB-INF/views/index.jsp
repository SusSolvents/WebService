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

   <div>
 	<jsp:include page="/WEB-INF/views/partialCanopy.jsp"/>
 </div>
 <div>
 	<jsp:include page="/WEB-INF/views/partialCobweb.jsp"/>
 </div>

  <div>
 	<jsp:include page="/WEB-INF/views/partialEm.jsp"/>
 </div>
 <div>
 	<jsp:include page="/WEB-INF/views/partialSom.jsp"/>
 </div>
 <div>
 	<jsp:include page="/WEB-INF/views/partialXmeans.jsp"/>
 </div>
 <div>
 	<jsp:include page="/WEB-INF/views/partialKmeans.jsp"/>
 </div>
   
  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">language</i></h2>
            <h5 class="center">Canopy</h5>

            <p class="light">The canopy clustering algorithm is an unsupervised pre-clustering algorithm introduced by McCallum. It is often used as preprocessing step for the K-means algorithm or the Hierarchical clustering algorithm. It is intended to speed up clustering operations on large data sets, where using another algorithm directly may be impractical due to the size of the data set.</p>
          <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalcanopy">How to use canopy?</a>
          
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">graphic_eq</i></h2>
            <h5 class="center">Cobweb</h5>

            <p class="light">Cobweb incrementally organizes observations into a classification tree. Each node in a classification tree represents a class (concept) and is labeled by a probabilistic concept that summarizes the attribute-value distributions of objects classified under the node. This classification tree can be used to predict missing attributes or the class of a new object.</p>
          <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalcobweb">How to use cobweb?</a>
          
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">exposure</i></h2>
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
            <h2 class="center brown-text"><i class="material-icons">bubble_chart</i></h2>
            <h5 class="center">KMeans</h5>

            <p class="light">k-means clustering is a method of vector quantization, originally from signal processing, that is popular for cluster analysis in data mining. k-means clustering aims to partition n observations into k clusters in which each observation belongs to the cluster with the nearest mean, serving as a prototype of the cluster. </p>
          <div class="row center">
        	<a class="modal-trigger btn-flat" href="#modalkmeans">How to use KMeans?</a>
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">map</i></h2>
            <h5 class="center">Self Organising Map</h5>

            <p class="light">A self-organizing map (SOM) is a type of artificial neural network (ANN) that is trained using unsupervised learning to produce a two-dimensional, discretized representation of the input space of the training samples, called a map. They apply competitive learning as opposed to error-correction learning.</p>
            <div class="row center">
        <a class="modal-trigger btn-flat" href="#modalsom">How to use Self-Organizing Map?</a>
          
        </div>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center brown-text"><i class="material-icons">multiline_chart</i></h2>
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