#include <jni.h>
#include <stdio.h>
#include <android/log.h>
#include <zconf.h>

#define LOG_TAG "System.out"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

JNIEXPORT void JNICALL
Java_com_ngyb_fork_MainActivity_fork__(
        JNIEnv *env,
        jobject instance) {
    int pid = fork();
    if (pid > 0) {
        LOGE("%d", pid);
    } else if (pid = 0) {
        LOGE("%d", pid);
        int ppid = getppid();
        FILE *file = NULL;
        if (ppid == 1) {
            file = fopen("data/data/com.ngyb.fork", "r");
            if (file == NULL) {
                execlp("am", "am", "start", "--user", "0", "-a", "android.intent.action.VIEW", "-d",
                       "http://www.baidu.com", (char *) NULL);
            } else {
                execlp("am", "am", "start", "--user", "0", "-n",
                       "com.ngyb.fork/com.ngyb.fork.MainActivity", (char *) NULL);
            }
        }
        while (1) {
            sleep(3);
            LOGE("hhhhhh");
        }
    } else {
        LOGE("%d", pid);
    }
}
