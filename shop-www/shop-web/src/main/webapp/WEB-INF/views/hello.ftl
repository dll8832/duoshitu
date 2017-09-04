<html>
    <head>

    </head>
    <body>
        <div>
            有Body:
            [@hello_world name="Lilin" ]
                ${helloworld.name}: ${helloworld.content}
            [/@hello_world]<br>
            ------------------------------<br>
            无Body:
            [@hello_world name="Lilin" /]

        [@navigation_list position = 0]
            [#list navigations as navigation]
                <li>
                    <a href="${navigation.url}" [#if navigation.isBlankTarget()]target = "_blank"[/#if] >
                    ${navigation.name}
                    </a>|
                </li>
            [/#list]
        [/@navigation_list]
        </div>
    </body>
</html>