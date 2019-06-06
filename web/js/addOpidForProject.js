/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(projectID) {
    $('#addopid').on('click', function() {
        alert("Reached 1");
      alert(projectID);// or $(this).val()
      alert("Reached 2");
      var projectID = this.value;
      var csrfPreventionSalt = $('#token').val(); 
      
      $.post('getProjectOPID.do', {
                    PID : projectID,
                    AntiCSRFToken : csrfPreventionSalt
                }, function(responseJson) {
                    if(responseJson.length == 0){
                        $('#OPIDList').html("");
                        $('#OPIDList').append('<option class="login login-submit"  value=0> Add OPID </option>');
                       alert("No OPID available for selected project. Please add a OPID.");
                       return;
                   }
                   $('#OPIDList').html("");
                   $('#OPIDList').append('<option class="login login-submit"  value=0> Select OPID </option>');
                   $.each(responseJson, function(index,OPID) {
                   // $("<option>").val(user.userid).text(user.username).appendTo($select);
                   
                   $('#OPIDList').append('<option class="login login-submit"  value='+OPID+'>' + OPID + '</option>');
 
      });

    });
});
});

