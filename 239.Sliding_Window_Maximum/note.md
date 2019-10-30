* Maintain a deque of index, which is ordered by both index and item's value descend.
* Pool the index form head, when switching windows moves beyond it.
* Pool the indexs from the rear, whose items are less than the current item.
