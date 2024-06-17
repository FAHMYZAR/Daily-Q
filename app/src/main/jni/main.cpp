#include <sys/types.h>
#include <pthread.h>
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring
Java_com_my_daily_MainActivity_Telegram(JNIEnv *env, jclass clazz) {
    return env->NewStringUTF("https://t.me/iCBear");
}



