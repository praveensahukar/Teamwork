/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
        $('#txtToDate').blur(function(event) {
                var sDate = $('#txtFromDate').val();
                var eDate = $('#txtToDate').val();
                var csrfPreventionSalt = $('#token').val();
                $.post('getEngineersAjax.do', {
                        txtFromDate : sDate,
                        txtToDate : eDate,
                        AntiCSRFToken : csrfPreventionSalt
                }, function(responseJson) {
                    
                   if(responseJson.length == 0){
                       alert("No engineers available for the selected dates.");
                       return;
                      
                   }
                   //  var $select = $("#EngineerList");
                   var x = $('#default');
                    x.remove();  
                     $('#EngineerList').html("");
                    $.each(responseJson, function(index,user) {
                   // $("<option>").val(user.userid).text(user.username).appendTo($select);
                   
                      $('#EngineerList').append('<option class="login login-submit"  value='+user.userid+'>' + user.username + ' : ' + user.team + '</option>');
                  
                    
                });
        });
})});