#include <jni.h>
#include "com_example_test_Hello.h"



 jstring  Java_com_example_test_Hello_sayHello
  (JNIEnv *env, jobject jobj){
	 return env->NewStringUTF("Hello");
 }

/*
 * Class:     com_example_test_Hello
 * Method:    sayHi
 * Signature: ()I
 */
 jint  Java_com_example_test_Hello_sayHi
  (JNIEnv *env, jclass jclass){
	 return 0;
 }
