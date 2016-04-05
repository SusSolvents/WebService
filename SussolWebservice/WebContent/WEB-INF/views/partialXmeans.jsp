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