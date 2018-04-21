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
    <script type="text/javascript" src="/js/ext-base-debug.js"></script>
    <script type="text/javascript" src="/js/ext-all-debug-w-comments.js"></script>
    <script type="text/javascript">

        var items = [];

        var proxy = new Ext.data.HttpProxy({
            url: '/api/products'
        });

        var columnModel = new Ext.grid.ColumnModel({
            defaults: {
                sortable: true
            },
            columns: [
                { id: "id", dataIndex: "id", header: "ID", width: 50},
                { id: "name", dataIndex: "name", header: "Наименование", width: 250, editor: new Ext.form.TextField( { allowBlank: false })  },
                { id: "cost", dataIndex: "cost", header: "Стоимость", width: 100, editor: new Ext.form.NumberField( { allowBlank: false, allowNegative: false, maxValue: 1000 })  }
            ]
        });

        var store = new Ext.data.Store({
            url: '/api/products',
            reader: new Ext.data.JsonReader({
                totalProperty: 'total',
                root: 'products',
                idProperty: 'id',
                fields: [
                    'id', 'name', 'cost'
                ]
            }),
            proxy: proxy
        });

        var grid = new Ext.grid.EditorGridPanel({
            store: store,
            cm: columnModel,
            clicksToEdit: 1
        });

        grid.on('afteredit', function(e) {
            Ext.Ajax.request({
                url: '/api/products',
                jsonData: Ext.util.JSON.encode(e.record.data),
                success: function() {
                    grid.store.commitChanges();
                }
            });

        });

        store.load({});


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
                layout: 'fit',
                items: [
                        grid
                ]
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
