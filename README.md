# AndroidMvpExample
#### 详细介绍：[地址www.dahei.me](http://dahei.me/2016/06/22/mvp/android%20MVP%E6%A8%A1%E5%BC%8F%E4%BB%8B%E7%BB%8D%E4%B8%8E%E5%AE%9E%E6%88%98/)

#### MVC和MVP的区别？

----------
为什么会出现MVP模式呢？这是因为原有的MVC模式有一些短板。比如在android开发中，activity充当着MVC中Controller的角色，但是在实际开发中处理view的逻辑和角色。当业务界面复杂时我的activity会显得很庞大。于是出现了MVP模式，它新增了一个Presenter角色用于处理数据和界面的模型以及逻辑，Activity仅仅用于展示界面和用户交互，这样就解决了MVC中角色不清的局面。
所以，MVP与MVC的重大区别：在MVP中View并不直接使用Model，它们之间的通信是通过Presenter (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，而在MVC中View会直接从Model中读取数据而不是通过 Controller。
在MVC里，View是可以直接访问Model的！从而，View里会包含Model信息，不可避免的还要包括一些业务逻辑。 在MVC模型里，更关注的Model的不变，而同时有多个对Model的不同显示，即View。所以，在MVC模型里，Model不依赖于View，但是View是依赖于Model的。不仅如此，因为有一些业务逻辑在View里实现了，导致要更改View也是比较困难的，至少那些业务逻辑是无法重用的。

**MVC模式结构**
- Model 业务逻辑和实体模型
- Controller 对应Activity
- View 视图以及布局文件

![Alt text](https://raw.githubusercontent.com/halibobo/BlogImage/master/blog/mvp/mvc_mvp.png)


**MVP模式结构**
- Model： 业务逻辑和实体模型
- View：用户交互和视图显示，在android中对应activity
- Presenter： 负责完成View于Model间的逻辑和交互

源码主要类的结构如下

![Alt text](https://raw.githubusercontent.com/halibobo/BlogImage/master/blog/mvp/ClassDiagram.png)

运行效果图如下：


![Alt text](https://raw.githubusercontent.com/halibobo/BlogImage/master/blog/mvp/mvp.gif)
