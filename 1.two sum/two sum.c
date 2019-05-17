#include <stdio.h>
#include <stdlib.h>
int* test(int s)
{
    int* p=(int*) malloc(sizeof(int)*s);
    int i;
    for(i=0;i<s;i++)
        p[i]=i;
        return p;
}
int main()
{
    int i;
    int *p=test(5);
    for(i=0;i<5;i++)
        printf("%d ",p[i]);
    printf("\n");
    free(p);
    return 0;
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    int i,j;
    int *p=(int*)malloc(sizeof(int)*2);
    for (i=0;i<=numsSize;i++)
        for (j=i+1;j<numsSize;j++)
            if (nums[i]+nums[j]==target) {
                p[0]=i;
                p[1]=j;
                break;
            }
    return p;
}

