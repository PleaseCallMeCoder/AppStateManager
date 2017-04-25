# AppStateManager

一个非侵入是的App状态管理工具

version 1.0.0

# 使用方式

1. 继承BaseStateLayout，自定义自己的几种加载状态，默认只有无数据和无网络状态

2. 在需要显示缺省页的Activity或者Fragment中实例化AppStateManager对象，并且调用init()方法初始化

3. 调用mManager.showContent()显示原始内容；mManager.showNoNetwork()显示无网络等等
