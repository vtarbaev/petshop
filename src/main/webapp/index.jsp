<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/ext-all.css">
    <script type="text/javascript" src="/js/ext-base-debug.js"></script>
    <script type="text/javascript" src="/js/ext-all-debug-w-comments.js"></script>

    <script type="text/javascript">
        Ext.onReady(function() {
            Ext.create('Ext.Panel', {
                renderTo: 'helloWorldPanel',
                height: 100,
                width: 200,
                title: 'Hello world',
                html: 'First Ext JS Hello World Program'
            });
        });
    </script>
</head>
<body>

</body>
</html>
