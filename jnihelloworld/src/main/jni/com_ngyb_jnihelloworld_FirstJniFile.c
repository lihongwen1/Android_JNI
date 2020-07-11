//
// Created by 南宫燚滨 on 2020/7/10.
//
#include "jni.h"
#include "com_ngyb_jnihelloworld_FirstJniFile.h"

JNIEXPORT jstring JNICALL Java_com_ngyb_jnihelloworld_FirstJniFile_helloWorld(JNIEnv *env,
                                                                              jclass obj){
  char* str = "Hello World";
  return (*env)->NewStringUTF(env,str);
}

