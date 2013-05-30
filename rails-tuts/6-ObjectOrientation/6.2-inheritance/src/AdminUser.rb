class AdminUser < User


attr_accessor :is_admin


def initialize first_name, last_name, email, is_admin

	super first_name, last_name, email

	@is_admin = is_admin

end

	


end