import { useState, useEffect } from "react";
import { ProductCard } from "./components/ProductCard/ProductCard";
import { ProductModal } from "./components/ProductModal/ProductModal";
import { Cart } from "./components/cart/Cart";
import { fetchpath } from "./service/api";
import "./App.css";

export const App = () => {
  const [productdata, setProductData] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [categoryFilter, setCategoryFilter] = useState("all");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [selectedProduct, setSelectedProduct] = useState(null);

  // Fetch products from backend
  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const data = await fetchpath("/products");
        setProductData(data || []); 
      } catch (err) {
        console.error(err);
        setError("Failed to fetch products");
      } finally {
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  const categories = ["all", "cpu", "keyboard", "monitor", "mouse", "mousepad"];

  // Filtered + searched products
  const filteredProducts = productdata
    .filter(product =>
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
    )
    .filter(product =>
      categoryFilter === "all" ? true : product.imageUrl.includes(categoryFilter)
    );

  // Loading state
  if (loading) return <div>Loading products...</div>;

  // Error state
  if (error) return <div>{error}</div>;

  return (
    <div className="app-container">

      {/* Search input */}
      <div className="search-container">
        <input
          type="text"
          placeholder="Search products..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </div>

      {/* Filter buttons */}
      <div className="filter-container">
        {categories.map((cat) => (
          <button
            key={cat}
            className={categoryFilter === cat ? "active" : ""}
            onClick={() => setCategoryFilter(cat)}
          >
            {cat.toUpperCase()}
          </button>
        ))}
      </div>

      {/* Product grid */}
      <div className="products-grid">
        {filteredProducts.length > 0 ? (
          filteredProducts.map((product) => (
            <ProductCard
              key={product.id}
              data={product}
              onClick={() => setSelectedProduct(product)}
            />
          ))
        ) : (
          <h2>No products found.</h2>
        )}
      </div>

      {/* Product Modal */}
      {selectedProduct && (
        <ProductModal
          product={selectedProduct}
          onClose={() => setSelectedProduct(null)}
        />
      )}

      {/* Cart modal */}
      <Cart />
    </div>
  );
};
