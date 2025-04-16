document.addEventListener("DOMContentLoaded", () => {
    const urlParams = new URLSearchParams(window.location.search);
    const keyword = urlParams.get("keyword");
  
    const clearBtn = document.getElementById("clearSearchBtn");
    const searchedBooks = document.getElementById("searchedBooksContainer");
    const allBooks = document.getElementById("allBooksContainer");
  
    if (keyword && keyword.trim() !== "") {
      // User searched something
      clearBtn.style.display = "inline-block";
      searchedBooks.style.display = "flex";
      allBooks.style.display = "none";
    } else {
      // No search keyword present
      clearBtn.style.display = "none";
      searchedBooks.style.display = "none";
      allBooks.style.display = "flex";
    }
  
    clearBtn.addEventListener("click", () => {
      window.location.href = "/Adminsearch"; // or wherever your all-books page lives
    });
  });
  