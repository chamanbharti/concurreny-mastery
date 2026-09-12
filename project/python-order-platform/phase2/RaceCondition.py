import threading
import time


class InventoryService:

    def __init__(self) -> None:
        self.stock = 1

    def reserve(self, customer_id: str) -> bool:

        print(
            f"[{threading.current_thread().name}] "
            f"{customer_id} checking stock. "
            f"Current stock = {self.stock}"
        )

        if self.stock > 0:

            time.sleep(0.1)

            self.stock -= 1

            print(
                f"[{threading.current_thread().name}] "
                f"{customer_id} reserved item. "
                f"Remaining stock = {self.stock}"
            )

            return True

        print(
            f"{customer_id}: Out of stock"
        )

        return False


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