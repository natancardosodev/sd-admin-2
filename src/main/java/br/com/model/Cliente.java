package br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author natancardosodev
 *
 */
@Entity
public class Cliente implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotEmpty(message="Nome é obrigatório")
		private String nome;
		
		private String email;

		/**
		 * @return id para acessar
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id para modificar
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return nome para acessar
		 */
		public String getNome() {
			return nome;
		}

		/**
		 * @param nome para modificar
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}

		/**
		 * @return email para acessar
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email para modificar
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

}