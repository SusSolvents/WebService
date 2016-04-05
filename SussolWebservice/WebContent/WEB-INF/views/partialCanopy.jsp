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