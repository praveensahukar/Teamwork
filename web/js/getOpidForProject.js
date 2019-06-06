/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $('#projectID').on('change', function() {
      alert( this.value ); // or $(this).val()
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

//$(document).ready(function() {
//        $('#projectID').blur(function(event) {
//                var projectID = $('#projectID').val();
//              
//                var csrfPreventionSalt = $('#token').val();
//                $.post('getProjectOPID.do', {
//                        PID : projectID,
//                        AntiCSRFToken : csrfPreventionSalt
//                }, function(responseJson) {
//                    
//                   if(responseJson.length == 0){
//                       alert("No OPID available for the selected project");
//                       return;
//                      
//                   }
//                   //  var $select = $("#EngineerList");
//                   var x = $('#default');
//                    x.remove();  
//                     $('#OPIDList').html("");
//                    $.each(responseJson, function(index,opidlist) {
//                   // $("<option>").val(user.userid).text(user.username).appendTo($select);
//                   
//                      $('#OPIDList').append('<option class="login login-submit"  value='+opidlist.opid+'>' + opidlist.opid + ' : ' + user.team + '</option>');
//                  
//                    
//                });
//        });
//})});



