//
//  main.cpp
//  opengl2
//
//  Created by Amin Meyghani on 6/30/13.
//  Copyright (c) 2013 Amin Meyghani. All rights reserved.
//

#include <iostream>
#include <GLUT/GLUT.h>
#include <OpenGL/OpenGL.h>
int Height=400, Width=400;
float Size=0.5;
void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 0.0, 1.0);
    glEnable(GL_POINT_SMOOTH);
    glPointSize(20.0);
    glBegin(GL_POINTS);
    glVertex2f(0.2, -0.5);
    glVertex2f(0.8, 0.7);
    glEnd();
    glBegin(GL_LINES);
    glVertex2f(-0.2, -0.5);
    glVertex2f(0.3, 0.8);
    glVertex2f(-0.8, -0.8);
    glVertex2f(0.8, -0.8);
    glEnd();
    glBegin(GL_LINE_STRIP);
    glVertex2f(-0.2, -0.5);
    glVertex2f(0.3, 0.8);
    glVertex2f(0.4, 0.1);
    glVertex2f(-0.8, 0.0);
    glEnd();
    glRotatef(50,1,0,1);
    glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
    glBegin(GL_QUADS);
    glVertex3f(0.0, 0.0, 0.0);
    glVertex3f(Size, 0.0, 0.0);
    glVertex3f(Size, Size, 0.0);
    glVertex3f(0.0, Size, 0.0);
    glVertex3f(0.0, 0.0, -Size);
    glVertex3f(Size, 0.0, -Size);
    glVertex3f(Size, Size, -Size);
    glVertex3f(0.0, Size, -Size);
    glEnd();
    glBegin(GL_LINES);
    glVertex3f(0.0, Size, 0.0);
    glVertex3f(0.0, Size, -Size);
    glVertex3f(0.0, 0.0, 0.0);
    glVertex3f(0.0, 0.0, -Size);
    glVertex3f(Size, 0.0, 0.0);
    glVertex3f(Size, 0.0, -Size);
    glVertex3f(Size, Size, 0.0);
    glVertex3f(Size, Size, -Size);
    glEnd();
    glutSwapBuffers();
}
int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE);
    glutInitWindowSize(Width, Height);
    glutCreateWindow("Hello OpenGL World");
    glutDisplayFunc(display);
    glutMainLoop();
}