package com.lams1989.cycledetection;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

	}

	public static void main(String args[]) {

		SinglyLinkedList llist1 = new SinglyLinkedList();
		int[] llistItem1 = { 141, 302, 164, 530, 474 };

		for (int i = 0; i < llistItem1.length; i++) {
			SinglyLinkedListNode llist_head1 = insertNodeAtHead(llist1.head, llistItem1[i]);
			llist1.head = llist_head1;

		}
		SinglyLinkedListNode headaux = llist1.head.next.next.next.next;
		headaux.next = llist1.head;
		System.out.println(cycleDetection(llist1.head));
	}

	static boolean cycleDetection(SinglyLinkedListNode head) {

		if (head == null)
			return false;

		SinglyLinkedListNode aux = head;
		List<SinglyLinkedListNode> nodesVisited = new ArrayList<SinglyLinkedListNode>();

		while (aux != null) {
			if (nodesVisited.contains(aux)) {
				return true;
			} else {
				nodesVisited.add(aux);
				aux = aux.next;
			}
		}

		return false;
	}

	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode nodeInsert = new SinglyLinkedListNode(data);
		if (head == null) {
			return nodeInsert;
		}
		nodeInsert.next = head;
		return nodeInsert;
	}

	static void printLinkedList(SinglyLinkedListNode head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

}
