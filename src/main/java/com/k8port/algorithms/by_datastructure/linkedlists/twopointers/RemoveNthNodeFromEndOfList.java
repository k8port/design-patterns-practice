package com.k8port.algorithms.by_datastructure.linkedlists.twopointers;


/**
 * Initialize 2 pointers, left and right, pointing head of linked list.
 * Move right pointer n steps forward, creating gap betwen left and right pointers of n nodes.
 * If right pointer is NULL, head node is target. Return head.next as new head of linked list.
 * If right pointer is not at end, move right and left pointers one step at a time, maintaining gap inbetween.
 * Ensure that once right pointer reaches end of linked list, left pointer is positioned just before node to be removed.
 * Once the right pointer reaches the end, update left.next to left.next.next. 
 * Skip over target node, effectively removing it from the linked list.
 * Return original head, which now points to updated linked list with nth node removed.
 */
public class RemoveNthNodeFromEndOfList {
}
