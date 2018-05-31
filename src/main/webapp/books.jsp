<%--
  Created by IntelliJ IDEA.
  User: zr
  Date: 2018/5/29
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示图书信息</title>
    <script src="js/jquery-2.1.1.min.js"></script>
</head>
<body>
<table id="tab" border="1" cellspacing="0" cellpadding="0" width="600px" align="center">
    <thead style="background-color: cornsilk;">
    <th height="35px">编号</th>
    <th>书名</th>
    <th>作者</th>
    <th>价格</th>
    <th>封面</th>
    </thead>
    <tbody align="center">
    </tbody>
   <%-- <tfoot>
    <tr>
        <td colspan="5" align="center">
            <button type="button" id="first">首页</button>
            |上一页|下一页|最后一页|第
           &lt;%&ndash; <select>
                <option>1</option>
                <option>2</option>
            </select>页|共？页&ndash;%&gt;
        </td>
    </tr>
    </tfoot>--%>

</table>
<script type="text/javascript">
    $.post("findBooks.action", function (list) {
        $("#tab tbody").empty();
        $.each(list, function (index, book) {
            var tr = $("<tr>");
            tr.append($("<td>" + book.id + "</td>"))
                .append($("<td>" + book.name + "</td>"))
                .append($("<td>" + book.price + "</td>"))
                .append($("<td>" + book.author + "</td>"))
                .append($("<td width='90px'><img src='images/" + book.cover + "' width=\"85px\" height=\"100px\"/></td>"))
            ;
            $("#tab tbody").append(tr);
        });

    }, "json");
</script>
</body>
</html>
