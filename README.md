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
	        implementation 'com.github.jarryleo:ZLogger:v1.0.1'
	}
  ```
