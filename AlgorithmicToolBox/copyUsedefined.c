#include<stdio.h>

int compare(char *s, char *t)
{
	while((*s!='\0' && *t!='\0') && (*s - *t)==0)
	{
		s++;
		t++;
	}
	return (*s-*t);
}

int main()
{
	char *s = "ha";
	char *t = "ha";
	printf("%s", (compare(s,t)==0) ? "EQUAL" : "NOT EQUAL");
}
