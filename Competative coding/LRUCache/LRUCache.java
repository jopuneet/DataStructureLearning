package CompetativeCoding;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private DoublyLinkedList pageList;
	private Map<Integer, Node> pageMap;
	private final int cacheSize;

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		pageList = new DoublyLinkedList(cacheSize);
		pageMap = new HashMap<Integer, Node>();
	}

	public void accessPage(int pageNumber) {
		Node pageNode = null;
		if (pageMap.containsKey(pageNumber)) {
			// If page is present in the cache, move the page to the start of
			// list
			pageNode = pageMap.get(pageNumber);
			pageList.movePageToHead(pageNode);
		} else {
			// If the page is not present in the cache, add the page to the
			// cache
			if (pageList.getCurrSize() == pageList.getSize()) {
				// If cache is full, we will remove the tail from the cache
				// pageList
				// Remove it from map too
				pageMap.remove(pageList.getTail().getPageNumber());
			}
			pageNode = pageList.addPageToList(pageNumber);
			pageMap.put(pageNumber, pageNode);
		}
	}

	public void printCacheState() {
		pageList.printList();
		System.out.println();
	}

	public static void main(String[] args) {
		int cacheSize = 4;
		LRUCache cache = new LRUCache(cacheSize);
		cache.accessPage(4);
		cache.printCacheState();
		cache.accessPage(2);
		cache.printCacheState();
		cache.accessPage(1);
		cache.printCacheState();
		cache.accessPage(1);
		cache.printCacheState();
		cache.accessPage(4);
		cache.printCacheState();
		cache.accessPage(3);
		cache.printCacheState();
		cache.accessPage(7);
		cache.printCacheState();
		cache.accessPage(8);
		cache.printCacheState();
		cache.accessPage(3);
		cache.printCacheState();
	}
}
