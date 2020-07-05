#include<stdio.h>
#include<string.h>
int reverse(char *s)
{
	int i = 0;
	int j = strlen(s)-1;
	while(i<j)
	{
		if(s[i++]!=s[j--])
			return 0;
	}
	return 1;
}

int main()
{
	char s[] = "saikiran";
    printf("%s", (reverse(s)!=0) ? "PALINDROME" : "NOT A PALINDROME");
}
