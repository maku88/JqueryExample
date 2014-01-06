<%--
  Created by IntelliJ IDEA.
  User: Maciek
  Date: 04.01.14
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>jQuery UI Accordion - Default functionality</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js" type="text/javascript"></script>
    <script src="http://www.trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="http://www.trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>


    <script>
        $(function() {
            $( "#accordion" ).accordion();
        });
    </script>

    <script>
        $(document).ready(function() {
            setupGrid();
            attachSendDataEvent();
            attachDeleteButton();
        });

        function attachSendDataEvent(){
            $("#sendData").click(function(){
                var data = "firstName=" + $("#firstName").val() + "&" +
                        "lastName=" + $("#lastName").val() + "&" +
                        "address=" + $("#address").val() + "&" +
                        "postcode=" + $("#postcode").val();

                $.post("person/put",
                        data,
                        dataSentOK
                );
            });
            return false;
        }

        function attachDeleteButton(){
            $("#deleteBtn").click(function(){
                var grid = jQuery("#dataTable").jqGrid();
                var rowNum = grid.getGridParam('selrow');
                if(rowNum){
                    var person = grid.getRowData(rowNum);
                    var data = "perId=" + person.id;
                    $.post("person/delete",
                            data,
                            dataSentOK
                    );
                }
            });
        }

        function dataSentOK(){
            jQuery("#dataTable").jqGrid().trigger("reloadGrid");
        }

        function setupGrid(){
            jQuery("#dataTable").jqGrid({
                url: "person/get",
                datatype: "json",
                jsonReader: {repeatitems: false, id: "ref"},
                colNames:['ID','First Name','Last Name', 'Address', 'Postcode'],
                colModel:[
                    {name:'id',index:'id', width:20},
                    {name:'firstName',index:'firstName', width:100},
                    {name:'lastName',index:'lastName', width:100},
                    {name:'address',index:'address', width:380},
                    {name:'postcode',index:'postcode', width:100}
                ],
                rowNum:5,
                rowList:[5,10,20],
                height:165,
                pager: "#pagingDiv",
                viewrecords: true,
                caption: "Names and Addresses"
            });
        }
    </script>

</head>
<body>

<div id="accordion">
    <h3>Lista Użądzeń</h3>
    <div id="tab1">
        <p>
            <script type="text/javascript">
                var modelAttributeValue = '${tag}';
                $(tab1).html(modelAttributeValue);
            </script>

        <div style="height:170px;">
            <div class="form">
                <div class="padding">
                    <label>First Name:</label> <input id="firstName"/><br/>
                    <label>Last Name:</label> <input id="lastName"/><br/>
                    <label>Address:</label> <input id="address" size="40"><br/>
                    <label>Postcode:</label> <input id="postcode"/><br/>
                    <button id="sendData">Send</button>
                </div>
            </div>
        </div>

        <!-- jqGrid will be injected into this DIV-->
        <h2>jqGrid Data Table</h2>
        <div>
            <table id="dataTable"></table>
            <div id="pagingDiv"></div>
            <button id="deleteBtn">Delete Row</button>
        </div>

        </p>
    </div>
    <h3>Dodaj Nowe</h3>
    <div>
        <p>
            Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
            purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
            velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
            suscipit faucibus urna.
        </p>
    </div>
</div>


</body>
</html>