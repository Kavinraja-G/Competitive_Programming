#include<stdio.h>
#include<stdlib.h>

int min(int a, int b)
{
    return ((a<b)?a:b);
}

void findAngle(int hour, int minute)
{
    //Some contraints reference to 12 hours
    if(hour == 12) hour = 0;
    if(minute == 60) minute = 0;

    //Finding the hourAngle and MinuteAngle
    int hourAngle = (hour*60 + minute)*0.5;
    int minuteAngle = minute*6;
    int angle = abs(hourAngle - minuteAngle);

    //Find the minAngle between 360-Angle and Original one
    angle = min(360-angle, angle);
    printf("\nAngle : %d",angle);

}

int main()
{
    int h,m;
    scanf("%d %d",&h,&m);
    findAngle(h,m);
}