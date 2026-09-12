import threading


class InventoryService:

    def __init__(self) -> None:
        self.stock = 1
        # self._lock = threading.Lock()
        self._lock = threading.RLock()

    def reserve(self, customer_id: str) -> bool:

        with self._lock:

            if self.stock <= 0:
                return False

            self.stock -= 1

            print(
                f"{customer_id} reserved item. "
                f"Remaining stock={self.stock}"
            )

            return True

def main() -> None:

    inventory = InventoryService()

    customer_a = threading.Thread(
        target=inventory.reserve,
        args=("Customer-A",),
        name="customer-a-thread",
    )

    customer_b = threading.Thread(
        target=inventory.reserve,
        args=("Customer-B",),
        name="customer-b-thread",
    )

    customer_a.start()
    customer_b.start()

    customer_a.join()
    customer_b.join()

    print(f"Final stock = {inventory.stock}"
    )


if __name__ == "__main__":
    main()    
        