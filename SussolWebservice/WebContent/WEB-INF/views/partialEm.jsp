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