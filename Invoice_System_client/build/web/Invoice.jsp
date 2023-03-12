<%@include file="Header.jsp" %>
<a href="New_Invoice.jsp">New Invoice</a>
<h2>Invoice</h2>
<script>
    $(document).ready(function () {
        getInvoiceId();
    })
    function getInvoiceId() {
        $.ajax({
            url: 'http://localhost:9090/api/allinvoices',
            method: 'get',
            contentType: 'application/json',
            success: function (resp) {
                $("#tbldata").empty();
                $.each(resp, function (i, d) {
                    let data="";
                    if(d.status=="Paid"){
                        data="<tr><td>" +(i+1)+ "</td><td>" + d.customer_name + "</td><td>" + d.invoice_date + "</td><td>" + d.total_ammount + "</td><td>" + d.paid_ammount  + "</td><td>" + d.remaining_ammount + "</td><td>" + d.status + "</td><td><a href='viewinvoice.jsp?id="+d.invoice_id+"'>View Invoice<a/></td></tr>"
                    }
                    else{
                        data="<tr><td>" +(i+1)+ "</td><td>" + d.customer_name + "</td><td>" + d.invoice_date + "</td><td>" + d.total_ammount + "</td><td>" + d.paid_ammount  + "</td><td>" + d.remaining_ammount + "</td><td>" + d.status + "</td><td><a href='make_payment.jsp?id="+d.invoice_id+"'>Make payment<a/></td></tr>"
                    }
        $("#tbldata").append(data)
                })
            }
        })
    }
</script>
<table class="table table-bordered">
    <thead>
        <tr class="bg-primary">
            <td>Sr no</td>
            <td>Customer Name</td>
            <td>Invoice Date</td>
            <td>Total Ammount</td>
            <td>Paid Ammount</td>
            <td>Reamaning Ammount</td>
            <td>Status</td>
            <td>Action</td>
        </tr>
    </thead>
    <tbody id="tbldata">

    </tbody>
</table>
<%@include file="Footer.jsp" %>