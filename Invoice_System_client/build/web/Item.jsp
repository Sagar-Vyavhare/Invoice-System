<%@include file="Header.jsp" %>
    <script>
        var obj1;
        $(document).ready(function () {
            Getallitems();
            $("#btnsubmit").click(function () {
                Additem();
            })
            $("#btnaddcudtomer").click(function () {
                $("#customermodal").modal("show");
            })

        })
        function deleteItem(id) {
            $.ajax({
                url: 'http://localhost:9090/api/itembyid?id=' + id,
                method: 'delete',
                contentType: 'application/json',
                success: function (resp) {
                    Getallitems();
                }
            })
        }

        function EditItem() {
            console.log("sagar");
            $.ajax({
                url: 'http://localhost:9090/api/item',
                method: 'put',
                data: JSON.stringify(obj1),
                contentType: 'application/json',
                success: function (resp) {
                    Getallitems();
                }
            })
        }
        function getItemById(id) {
            $.ajax({
                url: 'http://localhost:9090/api/itembyid?id=' + id,
                method: 'get',
                contentType: 'application/json',
                success: function (item) {
                    $("#customermodal").modal("show");
                    var tax = $("#tax").val(item.tax);
                    var name = $("#item_name").val(item.item_name);
                    var p_rate = $("#purchase_rate").val(item.purchase_range);
                    var s_rate = $("#selling_rate").val(item.selling_range);
                    var Stock = Number($("#Available_quantity").val(item.stock_quantity));
                    obj1 = item;
                }
            })
        }
        function Getallitems() {
            $.ajax({
                url: 'http://localhost:9090/api/item',
                method: 'get',
                contentType: 'application/json',
                success: function (resp) {
                    $("#tbldata").empty();
                    $.each(resp, function (i, d) {
                        $("#tbldata").append("<tr><td>" + (i + 1) + "</td><td>" + d.item_name + "</td><td>" + d.purchase_range + "</td><td>" + d.selling_range + "</td><td>" + d.tax + "</td><td>" + d.stock_quantity + "</td><td><input type='button' class='btn btn-danger btn-xs'value='Delete' onclick='deleteItem(" + d.item_id + ")'><input type='button' class='btn btn-info btn-xs'value='Edit' onclick='getItemById(" + d.item_id + ")'></td></tr>");
                    })
                }
            })
        }
        function Additem() {
            var tax = $("#tax").val();
            var name = $("#item_name").val();
            var p_rate = $("#purchase_rate").val();
            var s_rate = $("#selling_rate").val();
            var Stock = Number($("#Available_quantity").val());
            var obj = { "item_name": name, "purchase_range": p_rate, "selling_range": s_rate, "tax": tax, "stock_quantity": Stock };
            $.ajax({
                url: 'http://localhost:9090/api/item',
                method: 'post',
                data: JSON.stringify(obj),
                contentType: 'application/json',
                success: function (resp) {
                    Getallitems();
                    $("#customermodal").modal("hide");
                    $("#tax").val("");
                    $("#item_name").val("");
                    $("#purchase_rate").val("");
                    $("#selling_rate").val("");
                    $("#Available_quantity").val("");
                    document.getElementById("alert").style.display = "block";
                }
            })
        }
    </script>
    <h2>Item</h2>
    <p class="alert alert-success" id="alert" style="display:none;">Item added</p>
    <input type="button" value="Add Item" id="btnaddcudtomer" class="btn btn-primary">
    <div class="modal fade" id="customermodal">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" data-dismiss="modal" class="close"><span>&times;</span></button>
                    <h4>Item Details</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>item Id</label>
                                <input type="text" id="item_id" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>item name</label>
                                <input type="text" id="item_name" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Purchase Rate</label>
                                <input type="text" id="purchase_rate" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Selling Rate</label>
                                <input type="text" id="selling_rate" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Tax</label>
                                <input type="text" id="tax" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Available Quantity</label>
                                <input type="text" id="Available_quantity" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer" id="btn">
                    <input type="button" value="Submit" id="btnsubmit" class="btn btn-primary">
                    <input type="button" class="btn btn-warning" data-dismiss="modal" value="close">
                </div>
            </div>
        </div>
    </div>
    <table class="table table-bordered">
        <thead>
            <tr class="success">
                <td>sr. number</td>
                <td>Item Name</td>
                <td>Purchase Rate</td>
                <td>Selling Rate</td>
                <td>Tax(%)</td>
                <td>Available Quantity</td>
                <td>Action</td>
            </tr>
        </thead>
        <tbody id="tbldata">

        </tbody>
    </table>
    <%@include file="Footer.jsp" %>