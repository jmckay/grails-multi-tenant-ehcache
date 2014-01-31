// Configure the Multi Tenant Plugins
tenant {
  resolver.request.dns.type = "config"  //This is the default
  domainTenantMap {
    localhost = 1
    client2.com = 2
    client3.myco.com = 3
  }
  mode = "singleTenant"
  datasourceResolver.type = "config"
  dataSourceTenantMap {
    t1 = "java:comp/env/jdbc/client1DS"
    t2 = "java:comp/env/jdbc/client2DS"
    t3 = "java:comp/env/jdbc/client3DS"
  }
}
grails.plugins.dynamicController.mixins = [
        'grails.plugin.multitenant.ehcache.CacheManagementControllerMixin': 'com.yourcompany.yourapp.CacheManagementController'
]
grails.naming.entries = [
        "jdbc/client1DS": [
                type: "javax.sql.DataSource", //required
                auth: "Container", // optional
                description: "Data source test for client1", //optional
                driverClassName: "org.hsqldb.jdbcDriver",
                url: "jdbc:hsqldb:mem:devDB",
                username: "sa",
                password: "",
                maxActive: "8",
                maxIdle: "4"
        ],
        "jdbc/client2DS": [
                type: "javax.sql.DataSource", //required
                auth: "Container", // optional
                description: "Data source test for client1", //optional
                driverClassName: "org.hsqldb.jdbcDriver",
                url: "jdbc:hsqldb:mem:devDB",
                username: "sa",
                password: "",
                maxActive: "8",
                maxIdle: "4"
        ],
        "jdbc/configDS": [
                type: "javax.sql.DataSource", //required
                auth: "Container", // optional
                description: "Data source test for client1", //optional
                driverClassName: "org.hsqldb.jdbcDriver",
                url: "jdbc:hsqldb:mem:devDB",
                username: "sa",
                password: "",
                maxActive: "8",
                maxIdle: "4"
        ]
]
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
