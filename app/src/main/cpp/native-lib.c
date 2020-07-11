#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>
#include <string.h>

#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
//#define LOGI(...) _android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

JNIEXPORT jint JNICALL
Java_com_ngyb_jni_FirstJniFile_add(
        JNIEnv *env,
        jobject instance,
        jint x,
        jint y) {
    return x + y;
}

JNIEXPORT jstring JNICALL
Java_com_ngyb_jni_FirstJniFile_sayHelloInC(
        JNIEnv *env,
        jobject instance,
        jstring s_) {
    const char *s = (*env)->GetStringUTFChars(env, s_, 0);
    int len = strlen(s);
    char str[len+1];
    strcpy(str, s);
    LOGD("len = %d", len);
    int i;
    for (i = 0; i < len; i++) {
        *(str+i)+=1;
    }
    return (*env)->NewStringUTF(env, str);
}

JNIEXPORT jintArray JNICALL
Java_com_ngyb_jni_FirstJniFile_arrElementsIncrease(
        JNIEnv *env,
        jobject instance,
        jintArray intArray_) {
    jint *intArray = (*env)->GetIntArrayElements(env, intArray_, NULL);
    int len = (*env)->GetArrayLength(env, intArray_);
    LOGD("len = %d", len);
    int i;
    for (i = 0; i < len; i++) {
        *(intArray + i) *= 10;
        LOGD("value = %d", *(intArray + i));
    }
    //释放整形数组
    (*env)->ReleaseIntArrayElements(env, intArray_, intArray, 0);
    return intArray_;
}

JNIEXPORT void JNICALL
Java_com_ngyb_jni_SecondJniFile_chello(
        JNIEnv *env,
        jobject instance) {
    jclass clazz = (*env)->FindClass(env, "com/ngyb/jni/SecondJniFile");
    jmethodID jmethodId = (*env)->GetMethodID(env, clazz, "helloFromJava","()V");
    (*env)->CallVoidMethod(env, instance, jmethodId);
}

JNIEXPORT void JNICALL
Java_com_ngyb_jni_SecondJniFile_cadd(
        JNIEnv *env,
        jobject instance) {
    jclass clazz = (*env)->FindClass(env, "com/ngyb/jni/SecondJniFile");
    jmethodID jmethodId = (*env)->GetMethodID(env, clazz, "add", "(II)I");
    int result = (*env)->CallIntMethod(env, instance, jmethodId, 3, 4);
    LOGD("result = %d", result);
}

JNIEXPORT void JNICALL
Java_com_ngyb_jni_SecondJniFile_cprintString(
        JNIEnv *env,
        jobject instance) {
    jclass clazz = (*env)->FindClass(env, "com/ngyb/jni/SecondJniFile");
    jmethodID jmethodId = (*env)->GetMethodID(env, clazz, "printString", "(Ljava/lang/String;)V");
    jstring js = (*env)->NewStringUTF(env, "hello");
    (*env)->CallVoidMethod(env,instance,jmethodId,js);
}

JNIEXPORT void JNICALL
Java_com_ngyb_jni_MainActivity_showToast(
        JNIEnv *env,
        jobject instance) {
    jclass clazz = (*env)->FindClass(env, "com/ngyb/jni/MainActivity");
    jmethodID jmethodId = (*env)->GetMethodID(env, clazz, "showToast", "(Ljava/lang/String;)V");
    jstring js = (*env)->NewStringUTF(env, "hello");
    (*env)->CallVoidMethod(env,instance,jmethodId,js);
}
