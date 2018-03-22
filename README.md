### 说明

- 整体说明

网络模块采用了Volley,检测method耗时使用Hugo,注解采用butterKnife,图片加载采用了GIide,整体采用mvp架构方式

- 可以改善点的

Volley目前不支持重定向,所以https://m.taobao.com https://m.weibo.com,暂时请求不到数据
Volley 目前未做封装,仅支持get请求


- 功能实现
 
getIcon:暂时只支持获取贴吧Icon,解析时间可以通过打印对应showIcon()方法名即可,解析时间不到30ms
RateExchange:recycleView中item由于焦点,OOM问题,输入及时刷新暂未实现且未想到方法
