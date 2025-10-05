// display individual product details in grid



import { useContext } from "react";
import "./ProductCard.css";
import { CartContext } from "../cart/CartContext";

export const ProductCard = ({ data, onClick }) => {
  const {addToCart} = useContext(CartContext);
  return (
    <div className="product-card" onClick={onClick}>
      <img
        className="product-image"
        src={`http://localhost:8080/${data.imageUrl}`}
        alt={data.name}
      />
      <div className="product-name">{data.name}</div>
      <div className="product-price">₹{data.price.toFixed(2)}</div>

    </div>
  );
};
