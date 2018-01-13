/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.util.*;
import java.io.DataInputStream;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Edge1
{
int source;
int dest;
int weight;
}
class Floyd
{
public static void FloydWarshall(Edge1 edges[], int edgecount, int nodecount, int source)
{
String msg="No shortest path";
int infinity=50000;
int i, j;
int distance[]=new int[nodecount];
for(i=0; i<nodecount; i++)
distance[i]=infinity;
distance[source]=0;
for(i=0; i<nodecount; i++)
{
boolean somethingchanged=false;
for(j=0; j<edgecount; j++)
{
if(distance[edges[j].source]!=infinity)
{
int new_distance=distance[edges[j].source]+edges[j].weight;
if(new_distance<distance[edges[j].dest])
{
distance[edges[j].dest]=new_distance;
somethingchanged=true;
}
}
}
if(!somethingchanged)
break;
}
for(i=0; i<edgecount; ++i)
{
if(distance[edges[i].dest]>distance[edges[i].source]+edges[i].weight) 
System.out.println("Negative edge weight cycles detected!!!");
}
System.out.println("Note: 50000 denotes No shortest path");
for(i=0; i<nodecount; ++i)
System.out.println("The shortest distance between nodes "+source+" & "+i+" is "+distance[i]); 
new opFrame_f(nodecount,edgecount,source,distance).setVisible(true);
}
/*public static void main(String args[])
{
Scanner in=new Scanner(System.in);
System.out.print("Enter the number of nodes : ");
int nodes=in.nextInt();
System.out.print("Enter the number of edges : ");
int edge_count=in.nextInt();

Edge1 edges[]=new Edge1[edge_count];
for( int i=0; i<edge_count; i++)
{
edges[i]=new Edge1();
System.out.print("Enter source (from) ["+i+"] : ");
edges[i].source=in.nextInt();
System.out.print("Enter destination (to) ["+i+"] : ");
edges[i].dest=in.nextInt();
System.out.print("Enter the weight of corresponing edge ["+i+"] : ");
edges[i].weight=in.nextInt();
System.out.println();
}

for(int i=0; i<nodes;i++){
FloydWarshall(edges, edge_count,nodes,i);
}
}*/


}