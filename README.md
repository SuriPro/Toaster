# Toaster
  **Add it in your root build.gradle at the end of repositories:**
  
  	allprojects {
      repositories {
          maven { url 'https://jitpack.io' }
      }
	}
  
  **Add the dependency**

	dependencies {
	        implementation 'com.github.SuriPro:Toaster:1.0'
	}

 **Simple Usage**
 
 	ToastMessage.toast(context, message);
