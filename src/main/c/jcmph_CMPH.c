#include <jni.h>
#include <stdio.h>
#include <cmph.h>
#include <string.h>
#include "jcmph_CMPH.h"

JNIEXPORT jint JNICALL 
Java_jcmph_CMPH_init(JNIEnv * env, jobject o, jstring hashFunctionFile, jstring hashkey) {
	
	const char* functionFile = (*env)->GetStringUTFChars(env, hashFunctionFile, JNI_FALSE);
	FILE* mphf_fd = fopen(functionFile, "r");
	if(mphf_fd == NULL) {
		printf("file not found\n");
		return -1;
	}
  	cmph_t *hash = cmph_load(mphf_fd);
	
	const char *key = (*env)->GetStringUTFChars(env, hashkey, JNI_FALSE);
	unsigned int id = cmph_search(hash, key, (cmph_uint32)strlen(key));
	
	printf("%s = %d [%s]\n", key, id, functionFile);
    return id;
}