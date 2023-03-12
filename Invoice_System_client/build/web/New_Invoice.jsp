<%@include file="Header.jsp" %>
<script>
    let tblarray = [];
    let ttl = 0;
    let itemname = "";
    $(document).ready(function () {
        dropdownCust();
        dropdownItem();
        $("#quantity").keyup(function () {
            $("#quantity").empty();
            getTotal();
        })
        $("#add").click(function () {
            addItemToTbl();
        })
        $("#submit").click(function () {
            addToDatabase();
        })
    })
    function addToDatabase() {
        let invoice_items = [];
        $.each(tblarray, function (i, d) {
//                console.log(Number(d.item_id));
            invoice_items.push({"quantity": d.quantity, "items": {"item_id": Number(d.item_id)}});
        })
//            console.log(invoice_items)
        let date = $("#invoice_date").val();
        console.log(invoice_items);
        var st = {"invoice_date": date, "total_ammount": ttl, "customer": {"customer_id": $("#customer").val()}, "invoice_item": invoice_items};
        console.log(st);
        $.ajax({
            url: 'http://localhost:9090/api/invoice_details',
            method: 'post',
            data: JSON.stringify(st),
            contentType: 'application/json',
            success: function (resp) {
                alert(resp);
                window.location.href = "Invoice.jsp";
            }
        })
    }
    function getTotal() {
        let quan = Number($("#quantity").val());
        let stock = Number($("#stock").val());
        if (quan > stock) {
            document.getElementById("alert").style.display = "block";

            $("#alert").html("<span class='text-warning'>Only " + stock + " items available</span>")
            $("#add").prop('disabled', true);
        } else {
            document.getElementById("alert").style.display = "none";
            let rate = $("#rate").val();
            let tax = $("#tax").val();
            let totaltax = ((rate * quan) / 100) * tax;
            let ammount = (rate * quan) + totaltax;
            $("#total").val(ammount);
            if (ammount > 0) {
                $("#add").prop('disabled', false);
            } else {
                $("#add").prop('disabled', true);
            }
        }
    }
    function addItemToTbl() {
        tblarray.push({"item_id": $("#item").val(), "item": itemname, "rate": $("#rate").val(), "tax": $("#tax").val(), "quantity": $("#quantity").val(), "total": $("#total").val()});
        $("#tbldata").empty();
        ttl = 0;
        $.each(tblarray, function (i, d) {

            $("#tbldata").append("<tr><td>" + (++i) + "</td><td>" + d.item + "</td><td>" + d.rate + "</td><td>" + d.tax + "</td><td>" + d.quantity + "</td><td>" + d.total + "</td></tr>");
            ttl += Number(d.total);
        })
        $("#tbldata").append("<tr><td colspan='5'><span class='col-md-offset-11'>Total</span></td><td>" + ttl + "</td></tr>");
        $("#item").val("Select Item");
        $("#rate").val("");
        $("#tax").val("");
        $("#quantity").val("");
        $("#total").val("");
        $("#stock").val("");
        $("#add").prop('disabled', true)
    }
    function dropdownCust() {
        $.ajax({
            url: 'http://localhost:9090/api/customer',
            method: 'get',
            contentType: 'application/json',
            success: function (resp) {
                $("#customer").empty();
                $("#customer").append("<option disabled selected>Select Customer</option>");
                $.each(resp, function (i, d) {
                    $("#customer").append("<option value='" + d.customer_id + "'>" + d.customer_name + "</option>");
                })
            }
        })
    }
    function itemDetails() {
        let id = $("#item").val();
        console.log("sagar")
        $.ajax({
            url: 'http://localhost:9090/api/itembyid?id=' + id,
            method: 'get',
            contentType: 'application/json',
            success: function (resp) {
                $("#quantity").empty();
                $("#total").empty();
                itemname = resp.item_name;
                $("#rate").val(resp.selling_range);
                $("#tax").val(resp.tax);
                $("#quantity").val(0);
                $("#total").val(0);
                $("#stock").val(resp.stock_quantity);
            }
        })
    }
    function dropdownItem() {
        $.ajax({
            url: 'http://localhost:9090/api/item',
            method: 'get',
            contentType: 'application/json',
            success: function (resp) {
                $("#item").empty();
                $("#item").append("<option disabled selected>Select Item</option>");
                $.each(resp, function (i, d) {
                    $("#item").append("<option value=" + d.item_id + ">" + d.item_name + "</option>");
                })
            }
        })
    }
</script>
<a href="Invoice.jsp">All Invoices</a>

<div class="panel panel-info">
    <div class="panel-heading">
        <h2 class="text-center">Invoice</h2>
    </div>
    <div class="panel-body">
        <div class="col-md-6">
            <label for="">Customer</label>
            <select class="form-control" id="customer">
                <option>Select Customer</option>
            </select>
        </div>
        <div class="col-md-6">
            <label for="">Invoice Date</label>
            <input type="date" id="invoice_date" class="form-control">
        </div>
        <table style="margin-top:80px;">
            <tr>
                <td><label for="">Item</label></td>
                <td><label for="">Rate</label></td>
                <td><label for="" style="margin: 0px 5px;">Tax</label></td>
                <td><label for="" style="margin: 0px 10px;">Stock</label></td>
                <td><label for="" style="margin: 0px 15px;">Quantity</label></td>
                <td><label for="" style="margin: 0px 20px;">Total</label></td>
                <td><label for=""> </label></td>

            </tr>
            <tr>
                <td class="col-md-3"><select class="form-control" id="item" onchange="itemDetails()">
                        <option>Select Item</option>
                    </Select></td>
            <div class="col-md-9" style="border-radius:border-box;">
                <td><input type="text" id="rate" class="form-control" disabled></td>
                <td><input type="text" id="tax" class="form-control" style="margin: 0px 5px;" disabled></td>
                <td><input type="text" id="stock" class="form-control" style="margin: 0px 10px;" disabled></td>
                <td><input type="text" id="quantity" class="form-control" style="margin: 0px 15px;"></td>
                <td><input type="text" id="total" class="form-control" style="margin: 0px 20px;"></td>
                <td class="col-md-1"><input type="button" id="add" class="form-control btn btn-success"
                                            value="+" style="margin-left:10px;" disabled></td>
            </div>
            </tr>
        </table>
        <div id="alert"></div>
        <hr>
        <table class="table table-bordered table-condensed" style="margin-top:20px;">
            <thead>
                <tr>
                    <td>Sr no</td>
                    <td>Item</td>
                    <td>Rate</td>
                    <td>Tax</td>
                    <td>Quantity</td>
                    <td>Total</td>
                </tr>
            </thead>
            <tbody id="tbldata">

            </tbody>
        </table>
    </div>
    <div class="panel-footer">
        <input type="button" value="Submit" id="submit" class="btn btn-primary">
    </div>
</div>
<%@include file="Footer.jsp" %>
