import { createContext, useState, useEffect, useCallback } from "react";
import { fetchpath } from "../../service/api";

export const CartContext = createContext();

export const CartProvider = ({ children }) => {
  const [cart, setCart] = useState(() => {
    const savedCart = localStorage.getItem("cart");
    return savedCart ? JSON.parse(savedCart) : [];
  });

  // Add product to cart
  const addToCart = useCallback((product) => {
    setCart(prevCart => {
      const existing = prevCart.find(item => item.id === product.id);
      if (existing) {
        return prevCart.map(item =>
          item.id === product.id ? { ...item, quantity: item.quantity + 1 } : item
        );
      }
      return [...prevCart, { ...product, quantity: 1 }];
    });
  }, []);

  // Remove product completely
  const removeFromCart = useCallback((productId) => {
    setCart(prevCart => prevCart.filter(item => item.id !== productId));
  }, []);

  // Clear cart
  const clearCart = useCallback(() => {
    setCart([]);
  }, []);

  // Decrease quantity
  const decreaseQuantity = useCallback((productId) => {
    setCart(prevCart =>
      prevCart
        .map(item =>
          item.id === productId ? { ...item, quantity: item.quantity - 1 } : item
        )
        .filter(item => item.quantity > 0)
    );
  }, []);

  // Increase quantity
  const increaseQuantity = useCallback((productId) => {
    setCart(prevCart =>
      prevCart.map(item =>
        item.id === productId ? { ...item, quantity: item.quantity + 1 } : item
      )
    );
  }, []);

  // Persist cart to localStorage
  useEffect(() => {
    localStorage.setItem("cart", JSON.stringify(cart));
  }, [cart]);

  // Checkout
  const checkout = async () => {
    if (cart.length === 0) return; // nothing to checkout

    const payload = cart.map(({ id, quantity }) => ({ id, quantity }));

    try {
      const res = await fetchpath("/checkout", "POST", payload);
      console.log("Checkout successful:", res);
      clearCart(); // clear cart after successful checkout
    } catch (error) {
      console.error("Checkout failed:", error.message);
    }
  };

  return (
    <CartContext.Provider value={{
      cart,
      addToCart,
      removeFromCart,
      clearCart,
      decreaseQuantity,
      increaseQuantity,
      checkout
    }}>
      {children}
    </CartContext.Provider>
  );
};
