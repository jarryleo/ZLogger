# ZLogger
Log工具库，可以格式化json和捕捉crash日志，后续添加更多功能

To get a Git project into your build:

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ``` 
#### Step 2. Add the dependency
```
	dependencies {
	        debugImplementation 'com.github.jarryleo:ZLogger:v1.0.6'
	        releaseImplementation 'com.github.jarryleo:ZLogger-no-op:v1.0.0'
	}
  ```

releaseImplementation  为发行库，里面都是空实现     
debugImplementation 为调试库，日志只需要调试时候使用     
如果你有别除了 debug和release之外的环境，比方说 dev      
请使用 devImplementation 其它环境类似     