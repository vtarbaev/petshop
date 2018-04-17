<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 17.04.18
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/ext-all.css"/>
    <script type="text/javascript" src="/ext-base.js"></script>
    <script type="text/javascript" src="/ext-all.js"></script>
    <script type="text/javascript">

        var items = [];

        for (var i = 0; i < 100; i++) {
            items.push({
                id: i + 1,
                name: "name " + (i + 1),
                name1: "nameA " + (i + 1),
                name2: "nameB " + (i + 1)
            });
        }


        Ext.onReady(function () {

            var menu = {
                title: 'Menu',
                region: 'west',
                width: 250,
                split: false
            };
            var center = {
                title: 'Items',
                region: 'center',
                layout: 'fit'

            };

            var main = new Ext.Viewport({
                layout: 'border',
                items: [menu, center]

            });
        });
    </script>
</head>
<body>

</body>
</html>
