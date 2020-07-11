# 获取当前的路径
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
# 生成的模块的名字
LOCAL_MODULE    := FirstJniFile
# 指定要编译的代码的名字
LOCAL_SRC_FILES := com_ngyb_jnihelloworld_FirstJniFile.c
# 指定生成一个动态的链接库，Linux是.so windows下就是.dll
include $(BUILD_SHARED_LIBRARY)