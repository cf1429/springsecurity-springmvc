1、项目启动时需要配置maven启动环境，因为在maven中添加了tomact7的启动插件， 在idea中的配置如下：
a、在Edit Configurations 中添加一个maven配置
b、在name中添加项目名称
c、在Parameters -> Command line 中添加 clean tomcat7:run
d、通过debug启动项目
