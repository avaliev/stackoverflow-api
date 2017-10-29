document.addEventListener("DOMContentLoaded", function (event) {

    var testItem = {title: 'The Q', date: '2017-01-01', author: 'Author', url: 'stackoverflow.com'}

    var app = new Vue({
        el: '#app',
        data: {
            text: 'java tomcat',
            items: [
                testItem
            ]
        },
        methods: {
            doSearch: function () {
                var key = $("#searchInput").val();
                jQuery.getJSON("api/search?key=" + key, function (data) {
                    app.$data.items = data;
                })
            }
        }
    })
})

