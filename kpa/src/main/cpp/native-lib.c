#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <android/log.h>
#include <unistd.h>

#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

int flag = 1;

int getPressure() {
    return rand() % 101;
}

JNIEXPORT void JNICALL
Java_com_ngyb_kpa_MainActivity_begin(
        JNIEnv *env,
        jobject instance
) {
    jclass jclazz = (*env)->FindClass(env, "com/ngyb/kpa/MainActivity");
    jmethodID jmethodId = (*env)->GetMethodID(env, jclazz, "setP", "(I)V");
    while (flag) {
        sleep(1);
        (*env)->CallVoidMethod(env, instance, jmethodId, getPressure());
    }
}

JNIEXPORT void JNICALL
Java_com_ngyb_kpa_MainActivity_stop(
        JNIEnv *env,
        jobject instance
) {
    flag = 0;
}


