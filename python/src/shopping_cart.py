"""A shopping cart that holds items with prices."""

from dataclasses import dataclass


@dataclass(frozen=True)
class Item:
    """An item in the shopping cart."""

    name: str
    price: float


class ShoppingCart:
    """A shopping cart that holds items with prices."""

    def __init__(self):
        self._items: list[Item] = []

    def add_item(self, name, price):
        """Add an item to the cart."""
        self._items.append(Item(name, price))

    def get_total(self):
        """Return the total price of all items in the cart."""
        return sum(item.price for item in self._items)

    def get_item_count(self):
        """Return the number of items in the cart."""
        return len(self._items)

    def get_items(self):
        """Return a copy of the items list."""
        return list(self._items)

    def clear(self):
        """Remove all items from the cart."""
        self._items.clear()
